## Distributed Cache
![](./resources/distributedCache.png)
- LRU cache can be designed using a map and doubly linked list.

## Distributed Messaging Queue
![messagingQueue-1.png](./resources/messagingQueue-1.png)
![messagingQueue-2.png](./resources/messagingQueue-2.png)

## Pub Sub
![pubSUb-1.png](./resources/pubSUb-1.png)

## Rate Limiter
#### Rate limiting algorithms
- Token Bucket
  - Number of tokens are refilled in the bucket per unit time.
  - Each request removes one token and decision is made on token availibility in the bucket.
  - Adv - Easy to implement, less storage
  - DisAdv - Locking required
- Leaking bucket
  - Works on outflow rate
  - Keeps outflow counter
- Fixed Window Counter
- Sliding Window
- Sliding window counter
- Sliding window log

---

## Distributed Search
#### Search System
- Crawler
- Indexer
- Searcher
#### Indexing
- ElasticSearch
- Lucene
- Solr

![searchHLD.png](./resources/searchHLD.png)
