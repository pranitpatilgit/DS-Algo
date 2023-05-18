- Solidify the Requirements
- Scope the problem
- Engagement

---

- Ask Refining Questions
- Handle Data
- Start with High Level Design and then Go deep.
- Discuss the components
- Discuss the trade-offs

---

Questions to Ask
- Functional requirements
  - Needed directly
- Non Functional requirements

- Number of Users
- Number of Queries per second

Ask Yourself about the data
- Size of the data
- Rate of growth of data over time
- How will it be consumed by subsystems or users
- Read heavy or Write heavy
- Consistency or Eventual Consistency
- Durability of the data
- Privacy regulations on data

Consistency
- Eventual Consistency
  - Data is eventually replicated across all the replicas
  - It ensures High Availability
  - e.g. - DNS
  - Cassandra provides Eventual Consistency
- Casual Consistency
  - Stronger than eventual
  - Categorizes operations into dependent and independent operations
  - Casually related operations will be ordered
  - e.g. - replies to comments in a thread
- Sequential Consistency
  - Preserves the order of operations but not instant.
  - e.g. - Posts on social networking
- Strict Consistency
  - Transactions
  - Less performant


---

Think about following while designing
- Robustness (the ability to maintain operations during a crisis)
- Scalability
    - Size - Additions users
    - Administrative - Additional Orgs
    - Geographical - Additional Regions
- Availability
- Performance
- Extensibility
- Resiliency (the ability to return to normal operations over an acceptable period of time post disruption)
- Reliability
  - Probability that service will perform the functions for specified time.
  - MTBF and MTTR
- Maintainability
- Fault Tolerance

---

Resource Estimation
- Request Estimation
  - CPU Bound
    - RPS-CPU = Num-CPU Threads * 1 / Task-Time 
  - Memory Bound
    - RPS-Mem = RAM / Worker-Mem * 1 / Task-Time

- Server estimation
    - 500M Daily Users and 1 user makes 20 Req per Day
    - Total req per day = 1 B
    - Total Req Per sec = 115 K
    - Capacity Of server = 8000 RPS
    - No of servers needed = 15

    - Approximation
      - Num Requests per Sec / RPS fo Server

- Storage estimation
    - 250 M Daily Users
    - 3 Stores a Day
    - Avg Size of 1 req to be stored  - 250 B + 200 KB + 3 MB
        - Total req Per Day - 750 M
        - Total storage per day = 128 TB
        - Total Storage for 1 year = 46.72 PB

- Bandwidth estimation
