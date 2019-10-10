import Pyro4

@Pyro4.expose
class Storage(object):
    def __init__(self):
        self.stored_cartas = {}

    def store(self, duelista, carta):
        if not duelista in self.stored_cartas: 
            self.stored_cartas[duelista] = []
        cartas = self.stored_cartas[duelista]
        cartas.append(carta)
        self.stored_cartas[duelista] = cartas

    def retrieve(self, duelista, carta):
        cartas = self.stored_cartas[duelista]
        cartas.remove(carta)

    def listStoredCartas(self, duelista):
        cartas = []
        if duelista in self.stored_cartas.keys():
            cartas = self.stored_cartas[duelista]
        return cartas
