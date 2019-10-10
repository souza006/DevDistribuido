class Duelista(object):
    def __init__(self, cod, name):
        self.cod = cod
        self.name = name
        self.cartas= []

    def getCod(self):
        return self.cod
    
    def draw(self, carta, storage):
        if len(self.carta) < 10:
            self.cartas.append(carta)
        else:
            storage.store(self, carta)
