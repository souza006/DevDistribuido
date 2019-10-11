
import  Pyro4

@Pyro4.expose

class Comparador:

    def similar(self, num1, num2):

            if num1 == num2 :
                return 'iguais'
            else:
                return 'diferentes'
            


daemon = Pyro4.Daemon()


uri = daemon.register(similar)
nS = Pyro4.locateNS()
nS.register('objeto', uri)
print(uri)

daemon.requestLoop()
