package consumers

import (
	"encoding/json"
	"log"
    "os"
    "strconv"

	"github.com/mailgun/mailgun-go"
	"github.com/wagslane/go-rabbitmq"
)

var mg = mailgun.NewMailgun("sandbox0399e8667bc14f18b183432e2777a0a5.mailgun.org", os.Getenv("MAILGUN_API"))

type Order struct {
	OrderID    int     `json:"order_id"`
	ItemName   string  `json:"item_name"`
	ItemPrice  float64 `json:"item_price"`
}

func CreateOrderMessage(d rabbitmq.Delivery) rabbitmq.Action {
	log.Printf("consumed: %v", string(d.Body))

	var order Order
	err := json.Unmarshal(d.Body, &order)
	if err != nil {
		log.Printf("discarded: %s", err.Error())
		return rabbitmq.NackDiscard
	}

	_, _, err = mg.Send(mg.NewMessage(
		"My service <mailgun@sandbox0399e8667bc14f18b183432e2777a0a5.mailgun.org>",
		"New Order #"+strconv.Itoa(order.OrderID),
		"Item Name: "+order.ItemName,
		"Item Price: "+strconv.FormatFloat(order.ItemPrice, 'f', 2, 64),
	))
	if err != nil {
		log.Printf("requeued: %s", err.Error())
		return rabbitmq.NackRequeue
	}

	return rabbitmq.Ack
}
