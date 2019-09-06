import socket
import sys
import time

# Create a UDP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server_address = ('localhost', 30000)
message = 'This is the message.  It will be repeated.'

#inicio do calculo
clock_start = 0
time_start = 0


try:

    # Send data
    print('sending "%s"' % message, file=sys.stderr)
    sent = sock.sendto(message.encode('utf-8'), server_address)

    clock_start = time.clock()
    time_start = time.time()

    # Receive response
    print('waiting to receive', file=sys.stderr)
    data, server = sock.recvfrom(4096)
    print('received "%s"' % data, file=sys.stderr)

finally:
    print('closing socket', file=sys.stderr)
    sock.close()

#fim do calculo
clock_end = time.clock()
time_end = time.time()


#duração do envio
duration_clock = clock_end - clock_start
print ('clock:  duration_clock = ', duration_clock)

duration_time = time_end - time_start
print ('time:  duration_time = ', duration_time)
