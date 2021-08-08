# FeignClient-Implementation

Feign is a declarative HTTP client (_which means developers need only to declare and annotate an interface while the actual implementation is provisioned at runtime._) developed by Netflix. 
Feign aims at simplifying HTTP API clients besides REST Template.

In this project, feign client implementation is illustrated.

##### Scenario

_Let's suppose, there is a stockmarket where two companies join(Tesla and Rocket Lab). 
When one of their share(s) is/are sold or bought, worth of company in stock market is changed simultaneously._

##### Technical Design
There are two modules which are **_stocktransaction_** and **_companyworthcalculation_**. Both modules have their own spring main application. 
stocktransaction acts like consumer, and companyworthcalculation becomes producer.
Primary stockmarket transactions (_selling and buying_) are handled in **_stocktransaction_** module.

While stockmarket transactions are triggered, worth calculating service, in **__companyworthcalculation__** module, is invoked in order to calculate a worth of the company in stock market. 

##### To implement feign client, followings are applied to the project

To enable feign client, _@EnableFeignClients_ annotation is added to main application class. In this scenario, **__companyworthcalculation__** module is called by **_stocktransaction_** module, therefore _@EnableFeignClients_ annotation is added into _StockMainApplication.java_ class.

After enable feing client, an interface (_WorthCalculation.java_) is created in **_stocktransaction_** module which includes blueprints of services(invoked from **_stocktransaction_** module(_MarketTransactionService.java_) ) in **__companyworthcalculation__** module.

Finally, to acquire a communication between two modules, the interface is injected in _MarketTransactionService.java_ and services are invoked in this class w/o creating rest template.


Feing client provides a very easy way to call RESTful services.

### NOTES
Swagger Specification is implemented. When both project is running, you can send a request  via Swagger in your local machine.

Happy Coding...
