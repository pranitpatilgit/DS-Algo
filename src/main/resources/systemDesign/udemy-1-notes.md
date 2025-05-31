Horizontal Scaling with Load Balancers
    Works for stateless requests

DB Scaling
    Cold Standby (Secondary) Restore Backup from file periodically , Possible data loss
    Warm Standby (Secondary) Uses replication from Primary
    Hot Standby (Secondary) replication is realtime, both nodes can be used
    Sharding
        Make shard key such as there are less joins required

Problems with NoSQL
    Though to Join across shard
    Resharding
    Transaction Management

Data Lakes
    Dump unstructured data in storage (Amazon S3)
    Another process processes and creates the schema for that data

CAP Theorem 
    Consistency
    Availability
    Partition Tolerance (Scalability)

    Mysql - CA
    Cassandra  - AP
    MongoDB - CP
Decide CAP while choosing the database and the choose specific

Caching
    Have cache in every node or have a separate layer
    Cold start is a problem, fill the cache at startup
    Eviction Strategies - LRU, LFU, FIFO
    e.g. - Redis, memcached, Ehcache

Content Distribution/Delivery Network (CDN)
    Geographically distributed to reduce latency of static data (images, video, CSS)

Distributed Storage
    Amazon S3, Google Cloud Storage, HDFS
    HDFS
        Files are broken in blocks of specific size and replicated across nodes
        Name node is co-ordinator and has metadata
        Nodes storing data are called data nodes

Apache Spark
    Map reduce in memory by RDD and Data Frames
    Spark SQL
    MLLib - Machine Learning
    Streaming with Kafka
    OLAP

    Spark Context -> Cluster Manager(Spark or YARN) -> Executors 
    
Cloud Computing
    Think about all the solutions offered by different cloud providers
    <Put an image here>

Generative AI
    Retrieval Augmented Generation (RAG)
        Search in external data-sources more about the context /promt
        Add the retrieved context in the promt and then go the LLM
        

-----------------------------------

# Strategy

Working Towards Problem
    Start by clarifying requirements
    Create concrete requirements
    Ask about SLAs
    Ask about Non functional req - number of users and extra stuff
    Do not sit in silence - think out load so as to include everyone in the process

Work Backwords (Functional Requirements)
    Clarify the requirements from business perspective first and then technical later
    Start from customer experience and define requirements
    Use this to limit teh scope of design
    Identify WHO are the customers
        Use cases, time zones etc
    Scaling Requirements
        How many users, transaction rate
            Helps in decision of Horizontal scaling
        Scale of the data
            Helps in storage - distributed or simpler
        Define Latency Requirements SLAs
            Helps in caching , CDN decisions
        Availability Requirements (How crutial it is to the business)
            Helps in CAP theorem

Design
    Sketch HLD - High Level Components
    Go in details of each component cosidering scalability
    Identify Bottlenescks, maintainance, tradeoffs
    Think about monitoring
    
            