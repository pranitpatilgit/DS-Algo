## Design youtube
#### Requirements
- Functional
- NFRs - Scalability, Fault Tolerance, Consistency etc
#### Estimation
#### Storage schema
#### High Level Design
#### API design
#### Detailed Design
#### Evaluation
#### Distinctive component

---

## Design Yelp
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
- Place
- Place Info
- Categories
- Users
- Reviews
#### High Level Design
- Load Balancer
- Database 
  - SQL
- Distributed Cache
- Distributed Messaging Queue
- Blob Storage
- Application Server
- Monitoring
#### API design
#### Detailed Design
![yelpHLD.png](./resources/yelpHLD.png)
- Third Party Maps
- Quad Tree Servers
  - finds a place using location and radius
  - Quad tree is tree with 4 nodes- used to represent 2D maps
- Data Structure
  - Quad Tree
  - When number of places exceeds by a value then we split the segment in quad tree
  - This process can be repeated
  - This gets us more dense quad trees in urban areas and less in rural
  - easier for search
- Databases
  - SQL for Entities
  - Key value stores for search and quad tree
- Divide the maps into segments and place the places
  - Searching in small segments is easier and faster
![yelpHLD.png](./resources/yelpLLD.png)
#### Evaluation
#### Distinctive component

---

## Design Whatsapp
#### Requirements
- Functional
  - One to One and Group Conversations
  - Ack - sent delivered read
  - Sharing media files
  - persistent storage
  - Notifications
- NFRs
  - Scalability
  - Low latency
  - Fault Tolerance
  - Consistency
  - Security
  - High Availability
#### Estimation
#### Storage schema
#### High Level Design
- Load Balancer
- Database
  - SQL
- Blob Storage
- Messaging queue
- Application Servers
- CDN (Frequently accessed media)
![whatsappHLD.png](resources/whatsappHLD.png)
#### API design
- Send message
- Get Message
- Upload File
- Download  file
#### Detailed Design
- WebSockets
  - Websocket protocol keeps the connection open between client (who is online) and server
  - For billions of users we need a lot of servers
  - Websocket manager maintains the mapping and connections
- Do not use websockets for media as they are built for small dataset
- Encryption using asymetric keys
![whatsAppLLD.png](resources/whatsAppLLD.png)
#### Evaluation
#### Distinctive component

---

## Design Google Docs
#### Requirements
- Functional
  - Multiple uses reading and editing documents simultaniously
  - Conflict resolution
  - Word Suggestion
  - Views
  - History
- NFRs
  - High Scalability
  - Fault Tolerance
  - High Consistency
  - High Availability
  - Low latency
#### Estimation
#### Storage schema
#### High Level Design
- Load Balancer
- Database
  - SQL for user info
  - No SQL for documents
    - We can store data in JSON or Markdown format
- Blob Storage
- Application Servers
- Cache
- Messaging Queue and Topic
- CDN
- Cache
- Websockets
- Monitoring
![googleDocsHLD.png](resources/googleDocsHLD.png)
#### API design
- Create
- Edit (position(x,y), value, operation)
- Delete
- Get Document
#### Detailed Design
- Concurrency
  - Conflict Resolution
    - Operational Transformation
      - Lock free and non-blocking
      - Executes the operations in order and notifies all users
      - Challenging to develop
    - Conflict Free Replicated Data Type (CRDT)
      - Complex Data Structure but easy algorithm
- Websocket servers and Server manager to be added
  - Each server has local cache
#### Evaluation
#### Distinctive component
