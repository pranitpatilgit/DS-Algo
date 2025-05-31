# Working Towards Problem
- Start by clarifying requirements
- Create concrete requirements
- Ask about SLAs
- Ask about Non-Functional req - number of users, availability, SLAs
- Do not sit in silence - think out load so as to include everyone in the process

# Work Backwords (Functional Requirements)
- Clarify the requirements from business perspective first and then technical later
- Start from customer experience and define requirements 
- Use this to limit teh scope of design 
- Identify WHO are the customers
    Use cases, time zones etc
## Scaling Requirements
- How many users, transaction rate
    Helps in decision of Horizontal scaling
- Scale of the data
    Helps in storage - distributed or simpler
- Define Latency Requirements SLAs
    Helps in caching , CDN decisions
- Availability Requirements (How crutial it is to the business)
    Helps in CAP theorem
- Ask Yourself about the data
  - Size of the data
  - Rate of growth of data over time
  - How will it be consumed by subsystems or users
  - Read heavy or Write heavy
  - Consistency or Eventual Consistency
  - Durability of the data
  - Privacy regulations on data
---

## Design
- Start with HLD with High Level components
- Go In details of each component along with scaling
- Identify Bottlenecks, Tradeoffs, Maintainance
- Talk about Observability and monitoring

---

## Consistency
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

## RESHADED
- R - Requirements
  - Functional
  - NFRs - Scalability, Fault Tolerance, Consistency etc
- E - Estimation
- S - Storage schema
- H - High Level Design
- A - API design
- D - Detailed Design
- E - Evaluation
- D - Distinctive component