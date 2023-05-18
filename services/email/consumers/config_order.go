package order

import (
	"encoding/json"
	"fmt"
	"log"
	"os"

	"github.com/mailgun/mailgun-go"
	"github.com/wagslane/go-rabbitmq"
)

var mg = mailgun.NewMailgun("sandbox0399e8667bc14f18b183432e2777a0a5.mailgun.org", os.Getenv("MAILGUN_API"))

type ConfirmOrderMessage struct {
	OrderID    string `json:"order_id"`
	CustomerID string `json:"customer_id"`
	Title      string `json:"title"`
	Email      string `json:"email"`
}

func ConfirmOrderMessageHandler(d rabbitmq.Delivery) rabbitmq.Action {
	log.Printf("consumed: %v", string(d.Body))

	var message ConfirmOrderMessage
	err := json.Unmarshal(d.Body, &message)
	if err != nil {
		log.Printf("discarded: %s", err.Error())
		return rabbitmq.NackDiscard
	}

	_, _, err = mg.Send(mg.NewMessage(
		"My service <mailgun@sandbox0399e8667bc14f18b183432e2777a0a5.mailgun.org>",
		fmt.Sprintf("Order confirmation: #%s", message.OrderID),
		fmt.Sprintf(
			"Your order has been confirmed. Title: %s.\n\nYour customer id: #%s",
			message.Title,
			message.CustomerID),
		message.Email,
	))
	if err != nil {
		log.Printf("requeued: %s", err.Error())
		return rabbitmq.NackRequeue
	}

	return rabbitmq.Ack
}


