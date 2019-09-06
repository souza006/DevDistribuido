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
    print('Enviando "%s"' % message, file=sys.stderr)
    sent = sock.sendto(message.encode('utf-8'), server_address)

    clock_start = time.process_time()
    time_start = time.process_time()

    # Receive response
    print('Esperando receber', file=sys.stderr)
    data, server = sock.recvfrom(4096)
    print('Recebido "%s"' % data, file=sys.stderr)

finally:
    print('Fechando Socket', file=sys.stderr)
    sock.close()

#fim do calculo
clock_end = time.process_time()
time_end = time.process_time()


#duração do envio
duration_clock = clock_end - clock_start
print ('duração do relogio', duration_clock)

duration_time = time_end - time_start
print ('tempo de duração =  ', duration_time)
