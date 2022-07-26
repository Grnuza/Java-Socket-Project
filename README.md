# Java-Socket-Project-
The project converts a string to the corresponding hash encoding using sockets.
The project deals with a Multi Server which, using a function of an external class, given an input string by a client and the hash function with which it wants 
to encode it, returns the corresponding hash encoding.

The protocol used is TCP since the integrity of the data is important: 
the hash functions are in fact characterized by the so-called "avalanche effect",
a property whereby a small variation in input A produces a considerable variation in the hashes.

The available encoding functions are: MD5, SHA-1, SHA-256, SHA-512.

Operation example:

After connecting to the server, the client receives the various options available from the latter.
The server has a log function that allows you to keep track of the date, time and IP address of each client that connects with an output write (server side).
The client selects the type of hash encoding by selecting it from the 4 available, then the server asks the client for the string to be encoded.
At this point the client receives the encoding in the requested hash function from the server and can continue encoding until it decides to exit.
After the disconnection of the client, the server, similarly as in the connection, the server always keeps track with an output write (server side) of the date, 
time and IP address of each client that disconnects.

Theoretical notes:

We use Multi Server technology to allow multiple clients to access our server at the same time instead of blocking the connection to any clients who want to connect.
Hash functions are characterized by six fundamental points:

Determinism: input A produces and will always produce the same hash B.

Fixed length: the output produced by the hash functions has a fixed length. The encodings used in this project will have the respective lengths: 
MD5 128 bit, SHA-1 160 bit, SHA-256 256 bit, SHA-512 512 bit.

Avalanche effect: property whereby a small variation in input A produces a considerable variation in the hashes.

Non-injectivity: the same element of domain A can correspond to more elements of domain B.

Irreversibility: it is not possible to trace the input data from the output of a hash function.

Data-loss: the output of a hash function is characterized by the loss of bits of the input message (hence point 5).
