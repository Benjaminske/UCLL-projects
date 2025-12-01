class Password:
    def __init__(self, password):
        self.__password = password
    
    def verify(self, input_password):
        if(input_password == self.__password):
            print(True)
            return True
        else:
            print(False)
            return False
password = Password("abc123")     
password.verify("abc123")