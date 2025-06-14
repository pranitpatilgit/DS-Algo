## Design System to Process 1M messages per second
#### Requirements
- Functional
- NFRs
    - High Scalability
    - Fault Tolerance
    - High Availability
    - Consistency in users and auth
        - Can be weak in places and reviews
    - Low latency
#### Estimation
#### Storage schema
#### High Level Design
- Kafka (Batch processing) (Executors)
- 
#### API design
#### Detailed Design
#### Evaluation
#### Distinctive component

---

## Design HFT System
https://www.youtube.com/watch?v=iwRaNYa8yTw&list=PLJq-63ZRPdBvQnN9YQlpe5dKKg56MDpx4
#### Requirements
- Functional
  - Profit using spread
- NFRs
    - Ultra Low latency
    - High Accuracy
    - High Consistency
#### Estimation
#### Storage schema
#### High Level Design!
- Market Data Capture (Use colocated servers of exchange)
![MarketDataCapture.png](resources/MarketDataCapture.png)
- Processing Market Data
![MarketDataProcessing.png](resources/MarketDataProcessing.png)
  - FPGA (Field Programmable Gate Array)
    - Run without CPU (Tick to Trade execution)
  - Use lock free queue
- Market Making Strategy Engine  
![StrategyEngine.png](resources/StrategyEngine.png)
  - Constatantly recalculate spread
  - Once the decision made put out and order to smart order router
- Routing and Placing order 
![SmartOrderRouter.png](resources/SmartOrderRouter.png)
  - Pre Trade Checks - Check risk and Overspend etc,
  - Decision of where to put the order
- Audit and Analysis (Post Trade)
  - Order sent and status updates
  - Capture latency data performance metrics, post trade analysis
![postTrade.png](resources/postTrade.png)
#### API design
#### Detailed Design
#### Evaluation
#### Distinctive component