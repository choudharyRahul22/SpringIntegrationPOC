# SpringIntegrationPOC
Spring Integration POC

Channels Types:
1. Pollable Channel
2. Subscribe Channel

Pollable Channel has : QueueChannel and PriorityQueueChannel Implementation.
Subscribe Channel has : DirectChannel and PublishSubscribeChannel Implementation.

Bridge: To connect multiple channels like Pollable to Subscribe channel

Endpoints: 

1.Router Endpoint routes messages
2.Filter Endpoint filters the messages
3.Splitter Endpoint split the messages
4.Aggregators Endpoint aggregate the messages