# Design-Pattern-Examples
 ## Creational patterns: These patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code. 
    ## Factory Method: Provides an interface for creating objects in super class, but allows subclasses to alter the type of objects that will be created.
    ## Abstract Factory: Lets you produce families of related objects without specifing their concreate classes.
    ## Builder: Lets you construct complex objects step by step. It allows you to produce different types and representations of object using the same construction code.
    ## Prototype: Let you copy existing object without making you code dependent on their classes.
    ## Singleton: Lets you endsure that a class has only one instance, while providing a global access point to this instance.
 ## Structural patterns: These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.
    ## Adaptor: Allows object with incompatable interfaces to colabrate.
    ## Bridge: Lets split a large class of set of closely related classes into 2 seperate hierarchies-abstraction and impelmentation-which can be develop independently of each other.
    ## Composite:
    ## Decorator:Lets you attach a new behaviour to object by placing these objects inside special wrapper objects that contains the behaviour.
    ## Facade: Provide a simplefide interface  to a library, a framework, or any other complex set of classes.
    ## Flyweight:
    ## Proxy:
 ## Behavioral patterns: These patterns are concerned with algorithms and the assignment of responsibilities between objects.
    ## Chain of Responsibity:
    ## Command:
    ## Iterator:
    ## Mediator:
    ## Memonto:
    ## Observer: Lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they are observing.
    ## State: Lets an object alter its behaviour when its internal state changes, It appears as if it the object changed its class.
    ## Strategy:
    ## Tamplate method: Defines a skelton of algorithm in the superclass but lets subclasses override specific stpes of the algorithm without changing its structure.
    ## Visitor:


# SOLID design principles

## Single Responsibility Principle
every class should have a single responsibility or single job or single purpose.

## Open closed Principle (OSP)
open for extension, but closed for modification

## Liskov substitution Principle (LSP)
 child classes must be substitutable for their parent classes

## Interface Segregation Principle (ISP)
do not force any client to implement an interface which is irrelevant to them

## Dependency Inversion Principle
The Dependency Inversion principle states that our classes should depend upon interfaces or abstract classes instead of concrete classes and functions.

############################
## Questions IPC & AIDL
 
## 1. What is AIDL?
Answer: Android interface definition language to make RPC (Remote Procedure call) in android.

### 2. What is Parcels and Parcelables?
Answer: In Android Parcels are used to transmit messages, unlike serialization parcels are implanted as high performance containers for the Android inter process communication. By implementing the Parcelable interface you declare that it’s possible to transform (Marshall) your class into a Parcel and back (demarshall). Because the Parcels are designed for performance you should always use Parcelables instead of using the java serialization (which would also be possible) when doing IPC in android. Even when you are communicating with Intents you can still use Parcels to pass data within the intent instead of serialized data which is most likely not as efficient as Parcels.

### 3. What are the two methods of parceable interface?
   a) int describeContents();
      This method can be used to give additional hints on how to process the received parcel. For example, there could be multiple implementations of an Interface which extends the Parcelable Interface. When such a parcel is received, this method can then be to determine which object implementation needs to be instantiated.

   b) void writeToParcel(Parcel dest, int flags)
      This is the core method which is called when this object is to be marshalled to a parcel object. In this method all required data fields should be added to the “dest” Parcel so that it’s possible to restore the state of the object within the receiver during the demarshalling. The “flags” parameter indicates if the marshalling was triggered because the object becomes a return value of a remote method (if that’s the case the parameter is set to Parcelable.PARCELABLE_WRITE_RETURN_VALUE). If your model object contains references which could hinder the garbage collector from freeing the resources, you may want to check if the flag is set and remove the references at this moment to free resources which are limited on mobile devices.

### 4. What is CREATOR in Parcelable interface?
Answer: It is necessary to provide a static CREATOR field in any implementation of the Parcelable interface. The type of this CREATOR must be of Parcelable.Creator<T>. This CREATOR will act as a factory to create objects during the demarshalling of the parcel.

For this purpose, the Parcelable.Creator interface defines two methods where the type parameter T represents the Parcelable object:

           1.T createFromParcel(Parcel source)
            This method is called during the demarshalling of the object. The parameter source represents the parcel which contains the data of the corresponding object. During this method you can extract the data fields in the same sequence as you put them into the Parcel during the writeToParcel method. These fields can then be used to create an instance of the object.

            2.  T [] newArray(int size)
             This method returns just an empty array of the object with a given size.
 
 ### 5. What is application sandboxing?
Answer: Each application in Android runs in its own process. An application cannot directly access another application's memory space.

 ### 6.       What is IPC?
Answer: In order to allow cross-application communication, Android provides an implementation of interprocess communication (IPC) protocol. IPC protocols tend to get complicated because of all the marshaling/remarshaling of data that is necessary.

To help with this, Android provides Android Interface Definition Language, or AIDL. It is a lightweight implementation of IPC using a syntax that is very familiar to Java developers, and a tool that automates the stub creation.

### 7. How to allow for one application to call into another?
Answer: 1.Defining the AIDL interface
        2. Implement a stub for remote service.
        3. Expose the remote service to local client

 ### 8. How to bind service using I Binder class?
 Answer: There are total 3 ways to bind a service with application components:
                      1. Using IBinder class or Extending IBinder Interface
                      2. Using Messenger class
                      3. Using AIDL

 ### 9. What is activity Android Bound Service?
 Answer: A bound service is a service that allows other android components (like activity) to bind to it and send and receive data.                                                        A bound service is a service that can be used not only by components running in the same process as local service, but activities and services, running in different processes, can bind to it and send and receive data. When we implement a bound service we have always to extend Service class but we have to override onBind method too. This method returns an object that implements I Binder that can be used to interact with the service.

### 10. Why AIDL is required?
Answer: Each Android app run in it’s own process. So one application can’t directly access another app’s memory space. If you want to access some data from one application to another application, then we need to use inter process communication (IPC) like other platforms. So in Android IPC is otherwise known as AIDL. For this purpose Android provides a technique called Android Interface Definition Language (AIDL). It is a lightweight implementation of IPC just like C/C++ languages.

So to communicate between process or you say between applications, we need to implement AIDL in our Android application. In other words you can say the AIDL technique is a light weighted client server architecture in form of a service, which helps multiple applications to communicate between them self.  To do so we need the below steps.

1. AIDL interface- Define a AIDL interface which will be the interface between your applications.
2. Implement the the remote service- Remote service holds your data/method to expose to other applications for accessing data.
3. Expose the remote service to other local clients- The data/method we need to share with other applications needs to be expose so that other application can access and share data from the remote service.

### 11. Is compulsory to create same AIDL file with same package name to both Client (Activity) and Server (Service) ?
Answer: Yes. Otherwise it will show android.permission.INTERACT_ACROSS_USERS_FULL error.
