# Advance OOb

## Threads
 
two way to use threads
extends threads
implement runner

run method  
    has the black that you want to run in the thread
    if you call it it will be called as a normal method

start mehod
    it will call run mehtod but in a defferenet thread
    
    sleep it'll make the thread sleep for the mili seconds that you brovide'
    interpeted excpetion
    
    the priority of the thread
    from 1 to 10 
    1 low
    5 normal (Thread.Norm_Priority)
    10 maxsimum (Thread.Max_priority)
    
    you can set and get priority
    
    join
        excpetion is same as the sleep one

<p>Deamon thresds will all die together as soon as the main thread has died<p>

if they are child thread
isDeamon()
start() to start the thread 
interrupt() enables you to stop the thread from running and it'll continue when you press a key

joining a thread is making a thread whiting for the other thread until he finishes
join() will wait until the thread die and then i'll die with it
join(miliseconds) wait until either time is over or the thread finishes his task


<p>you have to create an objct of the class thread also if you you can make your own 
you must use try and catch <p>

if you want to prevent a second thrid from starting the action until the one before it finishes its task
you can use the synchronized before the methods (action) definition
you also can use it in a block by using synchronized(object) {//block} (using variables or may be methods)
finally you can synchronized a object
new  v


## Network

you have to get the IP address
UDP faster than TCP but no garenty that the packgaes will be sent

1024 ports are all used by computer so you should not use them

IP address 
Domain name is the name of the device I would say
URL is the link in which you can accsses
    http (protocoal) hosst name: www.flksj.com /portnumber which is 80 for the http/a path or file


factory methods are sttic mehtods that return the object of the class

java.Net package is used when dealing with anything regarding networking

net.InetAddress private constrocters so you have to make a its object using factory method 
    getLocalHost() object of information the local host 
        it might throw an UnknownHostExciption if there isn't a Host
    getHost Name & Address()
    getByName("web Domain") a factory method
        gives info that domain
    getAllByName a factory mehod
        all info of a domain(addresses of a domain in an array)
    
net.URL (uniform resource locator)
MalformedURLException 
    new URL("url");
    new URL("protocal", "host", int (port), " file ");
    new URL("protocal", "host", "file");

    getprotocol
    getHost
    getPort 
    getFile
    toExternalForm will get all of these ^^ in a string form 
        if you don't write any of these parts in the constructor it'll be -1 or blank
        Saleh1975
        0022

    importin, extiending, parts;
    exceptions,


    
    URLConnection class new (using open Connection) a general class that works with all
    used to make connation to the web site addrecc

    openConnection method (MarformedURLException, IOException) new  (Url ob.get)
    return an object of url connection
    
    HttpURLConnection a sub class of URLConnection
        used fot the http in most of the websides now a days

    git request method (a way of doing a request) 
    post reques method
        
        getReponsCode
        
        respons message
        
        header file
            to store it uses map and list
            


    
    getDate()
        returns a long value representing a date for establishing the domin i guess
        
    getcontentlength 
        length of the charachter
        
    getExpiration 
            give you the expiration data
            
    getcontentType 
        gives you the whither it is html etctera
        
" Stream
    package java.io
    InputStream low level it reads in a form of a byte
    
    high level streams uses a 
    
    read 
        get us a chacrachter in a byte
        
        
    Socket 
    for both of the divices
    it work on a port number 
    the server has a server socket (port number(int))
    the client has a socket  (the addresss of the server, portNumber (int) of the server)
    both of the socket is a classes
    accept() return object of socket
    it will wait until a connection happen
    
    Socket("localhost", 2345) //if the server and client in the same device else you right the ip address or domain name
    ServerSocket(port number)

    Scanner (socket.getInputStream())//it enable us to 
    when you use streams and socktes its a good practise to close them
    PrintWriter (disfnation, bool (for spesfitying the storage of the inputs whether it's kept in the stream(false the default) the true wil give it out));
    enables us to give output to the distenation of the output

    you can use a thread to make the server daligate the work to it so the server will be free to accsept a many clients.

## database
    you have to know the name of a data base to connect to it
    also each on will have a table also you know the table

    giving a table and write it in the final.
    
    "creating
    CREATE DATABASE databaseName
    
    "creating a table
    CREATE databaseName

    "insert records
iiI
    "reading records

    "ubdating & deleting reacord

    Query is like a 

    exam
    database name, table name, all column and you have to connect your

    tupile
    field 
    atrbute

    1286 statements


    close connection
    hava.sql
    old the driver
    ...etc pn 1393

    get connnection

     as will yo uhave to specifiy theeeee sity

     

# Algo&datastur

## BTS

    delection 
    if leaf delete directly
    if one child tkae the child and put if in place of the deleted node
    if two childs we finde the predecssor or the successor in the in order traverse

##   B-Trees

    the node can have more than one value
    but they have to be sorted
    
    order of the b tree is teh number of the values - 1
    ---
    server
      ServerSocket ss = new ServerSocket(3210);
        Socket s = ss.accept();
        System.out.println("a client has been conected to the server");
        while (true) {
            Scanner clientInput = new Scanner(s.getInputStream());
            String clientMessage = clientInput.next().trim();
            PrintWriter serverOutPut = new PrintWriter(s.getOutputStream(), true);
            Scanner userInput = new Scanner(System.in);


            if (!clientMessage.equalsIgnoreCase("stop")) {
                System.out.println("the client Message is: " + clientMessage);
                System.out.println("Enter your reply");
                String serverReply = userInput.next().trim();
                serverOutPut.println(serverReply);
            }
            else {
                serverOutPut.flush();
                break;
            }
        }
        System.out.println("the connection has been terminated");
       
       
    client
        Socket cs = new Socket("localhost", 3210);
        Scanner userInput = new Scanner(System.in);

        while (true) {
            
        System.out.println("Enter a message to send the server ");
        String userMessage = userInput.next().trim();

        PrintWriter clientWriter = new PrintWriter(cs.getOutputStream(), true);
        clientWriter.println(userMessage);
        System.out.println("Message has been sent");
        
        Scanner serverInput = new Scanner(cs.getInputStream());
        if(serverInput.hasNext())
            System.out.println("the replity form the server is:" + serverInput.next());
        else
            break;
        }

