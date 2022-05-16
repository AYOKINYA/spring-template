import sys
import zmq

port = "5556"
if len(sys.argv) > 1:
    port =  sys.argv[1]
    int(port)
    
if len(sys.argv) > 2:
    port1 =  sys.argv[2]
    int(port1)

# Socket to talk to server
context = zmq.Context()
socket = context.socket(zmq.SUB)

print ("Receive Data from Server...")
try:
    socket.connect("tcp://localhost:5556")
except  Exception as e:
    print(e)

if len(sys.argv) > 2:
    socket.connect("tcp://localhost:%s" % port1)

# Subscribe to zipcode, default is NYC, 10001
topicfilter = 'control-robot'
socket.setsockopt_string(zmq.SUBSCRIBE, topicfilter)

while True:
    topic, data = socket.recv_multipart()
    print(topic.decode('utf-8'), data.decode('utf-8'))

    # ret = socket.recv_multipart()
    # print(ret)