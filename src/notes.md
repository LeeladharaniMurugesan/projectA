 1. Constructor automatically invoked when application context is loaded
  1. First JVM loaded
  1. ApplicationContext is loaded
  1. ApplicationContext reads xml configuration file
  1. ApplicationContext pre-loads one object for each bean in the config file
      if not marked as        lazy-init="true"
  1. lazy-init="true" this inform spring container not to preload object for this bean
  1. For lazy-init means obect is created only when the getBean() method is called 
  1. For pre-init beans getBean() return the reference of the preloaded object.
  1. By default only one object for every bean is created(singleton)
  1. Singleton: Atleast one object for every class but not more than one object
  1. Spring for lazy-init beans creates a singleton object on firstcall of getBeans methods()
  1. And then uses that object for futures getBean() method calls.
  
  
---  
  
## Prototype

- Prototype beans are by default lazy-init  
- Prototypes are not singleton  
- A new object is created for prototype when getBean() method is called everytime

 ``` xml
      <bean  id="actor" class = "com.chainsys.projectA.beans.Actor"scope="prototype"></bean>	
 ```
----

##Bean with parameterize constructor

 ```
    <bean  id="film" class = "com.chainsys.projectA.beans.Movie" >
  	 		<constructor-arg type="java.lang.String"  value = "vikram" />
  	 		<constructor-arg type="java.lang.String"  value = "kamal" />
  	 		</bean> 
 ```
 
 ----
##Factory method


 ```  
    <bean id="nvsilunch" class="com.chainsys.projectA.beans.Lunch" factory-method = 	"createNonVegSouthIndianLunch"
		factory-bean = "lf" />
			<bean id="vsilunch" class="com.chainsys.projectA.beans.Lunch" factory-method = 	"createVegSouthIndianLunch"
		factory-bean = "lf" />
			<bean id="nilunch" class="com.chainsys.projectA.beans.Lunch" factory-method = 	"createNorthIndianLunch"
		factory-bean = "lf" />
			<bean id="chlunch" class="com.chainsys.projectA.beans.Lunch" factory-method = 	"createChineseLunch"
		factory-bean = "lf" />
	</beans>
 ```