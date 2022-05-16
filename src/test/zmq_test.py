import json
import zmq
import sys
import time

def zmq_pub_connection():
        try:            
            zmq_context = zmq.Context()
            zmq_socket = zmq_context.socket(zmq.PUB)
            zmq_socket.connect('tcp://127.0.0.1:5557')
        except:
            raise Exception("ZMQ not Established")

        return zmq_socket


def main():

    try :
        zmq_pub_conn = zmq_pub_connection()

        robot_status = {}
        robot_status["power"] = 3
        robot_status["battery"] = 78
        robot_status["run_time"] = 100 
        robot_status["estop"] = 1

        data = json.dumps(robot_status)
        print(data)

        while (True):
            zmq_pub_conn.send_multipart([b'robot-status', data.encode('utf-8')])
            time.sleep(3)

    except:
        raise Exception("ZMQ not Established")

    return True

if __name__ == "__main__":
    if not main():
        sys.exit(1)