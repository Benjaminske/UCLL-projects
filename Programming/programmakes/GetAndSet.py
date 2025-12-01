class Auto:
    def __init__(self,kleur,merk):
        self.set__verf(kleur)
        self.merk = merk
        
    #hierboven staat de constructor
        
    def set__verf(self, Nieuwe_kleur):
        self.__kleur = Nieuwe_kleur
            #hierboven staat de method
    
    def get_kleur(self):
        return self.__kleur
    def hey(self,naam):
        if(naam == "bennie"):
            print("Hey " + naam)
        if(naam == "niet bennie"):
            raise ValueError("jij bent niet bennie! ga weg!")

Mijn_auto = Auto("zwart", "Porshe")
    #hierboven maak ik mijn product

print(Mijn_auto.get_kleur())
Mijn_auto.set__verf("Rood")
print(Mijn_auto.get_kleur())
#Mijn_auto.hey("niet bennie")
    #hierboven gebruik ik de method
    
#class Person:
   # def __init__(self, n, a):
        #self.name = n
        #self.age = a

    #def __repr__(self):
        #return f"Person('{self.name}', {self.age})"

#g = Person("Geek", 9)
#print((repr(g)))
