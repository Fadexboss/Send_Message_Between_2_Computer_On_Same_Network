# Send_Message_Between_2_Computer_On_Same_Network

In this project, a system was written that will allow two different computer users working on the same server to communicate. Before running the project, by using the codes in the PC_1 project, you can get the IPv4 value of PC_2 via CMD (Command Prompt) via Wifi, where PC_2 is connected to the same network, and start the project using this value. PC_1 and PC_2 codes are similar, so just to explain PC_1 codes:


* final String iP_V4 = "Second_Pc_Ipv4": Specifies the IPv4 address of the second computer to be connected. This value should be replaced with the IP address of the second computer.

* Socket socket = new Socket(IPV4, 9999) : Creates a socket with the specified IP address and port number. This is used to communicate with the other computer.

* PrintWriter out = new PrintWriter(socket.getOutputStream(), true): Provides output stream through the socket. This will be used to send messages to the other computer.

* BufferedReader in= new BufferedReader(new lnputStreamReader(socket.getlnputStream())) : Soket üzerinden gelen veriyi okumak için bir girdi akışı oluşturur. Bu, diğer bilgisayardan gelen mesajları almak için kullanılır.

* BufferedReader userlnput = new BufferedReader(new lnputStreamReader(System.in)) : Creates an input stream to read input received from the user. This is used to receive messages to be sent by the user.

* Thread readThread = new Thread(() -> { ... }) : Creates a thread to read incoming data. This thread reads messages from the other computer and prints them to the screen.

* readThread.start(): Starts the thread created for the reading process.

* while ((userlnputMessage = userlnput.readline()) != null) { out.println(userlnputMessage) }: As long as the user continues writing messages, it writes each line entered by the user to the socket via PrintWriter to send it to the other computer.

* catch (IOException e) { ... }: Handles the program's error messages in case of any socket or input/output error.
  
