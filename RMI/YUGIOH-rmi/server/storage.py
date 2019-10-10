import Pyro4

@Pyro4.expose
class Storage(object):
    def __init__(self):
        self.stored_digimons = {}

    def store(self, digiescolhido, digimon):
        if not digiescolhido in self.stored_digimons: 
            self.stored_digimons[digiescolhido] = []
        digimons = self.stored_digimons[digiescolhido]
        digimons.append(digimon)
        self.stored_digimons[digiescolhido] = digimons

    def retrieve(self, digiescolhido, digimon):
        digimons = self.stored_digimons[digiescolhido]
        digimons.remove(digimon)

    def listStoredDigimons(self, digiescolhido):
        digimons = []
        if digiescolhido in self.stored_digimons.keys():
            digimons = self.stored_digimons[digiescolhido]
        return digimons
