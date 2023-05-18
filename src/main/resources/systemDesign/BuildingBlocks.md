Domain Name System
- Name Servers
  - Responds to user Queries
- Resource Records
    - Database of url and ip mapping
    - Types
      - A = hostname - ip (server.abc.com - 192.168.0.0)
      - NS = Domain Name - hostname (abc.com - server.abc.com)
      - CNAME = Alias to canonical hostname (abc.com - server1.primary.abc.com)
      - MX = Mail server - CNAME

---

## Load Balancing
###Load Balancer Provides following capabilities
- Scalability
    - Upscaling and Downscaling is transparent to end user
- Availability
    - Hide faults and failure of servers. If some servers go down, system is still functional
- Performance
    - Improves performance and resource utilization
- Health Checking - using heartbeat
- Predictive Analytics - Predict traffic patterns
- Service Discovery
- Security

####Global Server Load Balancer
- Balance the requests to different regions
####Local Load Balancer
- Withing Data center

###Algorithms of Load Balancers
- Round Robin
  - Widely used
  - Easy
  - Limitations
    - Uneven load distribution in case of GSLB
    - Does not consider server crashes, if the IPs are cached
- Weighted Round Robin
- Least Connection
- Lease response Time
  - In performance sensitive scenarios
- IP Hash
- URL Hash

###StateFull and StateLess Balancing
- Statefull Load balancer maintains state of the session
  - Retail a data structure to map clients to hosting server
  - Limit Scalability
- Stateless is more faster and lightweight
  - Uses consistent hashing