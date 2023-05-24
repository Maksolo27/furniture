package main

import (
	"fmt"
	"log"
	"os"
	"os/signal"
	"syscall"

	"github.com/maksolo/email/consumers"
	"github.com/wagslane/go-rabbitmq"
)

func main() {
	connURL := "amqp://user:user@localhost"
	if mp := os.Getenv("AMQP_URL"); mp != "" {
		connURL = mp
	}

	conn, err := rabbitmq.NewConn(
		connURL,
		rabbitmq.WithConnectionOptionsLogging,
	)
	if err != nil {
		log.Fatal(err)
	}
	defer conn.Close()

	createOrderConsumer, err := rabbitmq.NewConsumer(
		conn,
		consumers.CreateOrderMessage,
		"create_order",
		rabbitmq.WithConsumerOptionsRoutingKey("create_order"),
		rabbitmq.WithConsumerOptionsExchangeName("emails"),
		rabbitmq.WithConsumerOptionsExchangeDeclare,
	)
	if err != nil {
		log.Fatal(err)
	}
	defer createOrderConsumer.Close()

	confirmOrderConsumer, err := rabbitmq.NewConsumer(
		conn,
		consumers.ConfirmOrderMessageHandler,
		"confirm_order",
		rabbitmq.WithConsumerOptionsRoutingKey("confirm_order"),
		rabbitmq.WithConsumerOptionsExchangeName("emails"),
		rabbitmq.WithConsumerOptionsExchangeDeclare,
	)
	if err != nil {
		log.Fatal(err)
	}
	defer confirmOrderConsumer.Close()

	sigs := make(chan os.Signal, 1)
	done := make(chan bool, 1)

	signal.Notify(sigs, syscall.SIGINT, syscall.SIGTERM)

	go func() {
		sig := <-sigs
		fmt.Println()
		fmt.Println(sig)
		done <- true
	}()

	fmt.Println("Awaiting signal")
	<-done
	fmt.Println("Stopping consumer")
}
