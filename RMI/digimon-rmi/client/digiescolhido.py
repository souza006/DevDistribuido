class Trainer(object):
    def __init__(self, cod, name):
        self.cod = cod
        self.name = name
        self.digimons = []

    def getCod(self):
        return self.cod
    
    def train(self, digimon, storage):
        if len(self.digimon) < 3:
            self.digimons.append(digimon)
        else:
            storage.store(self, digimon)
