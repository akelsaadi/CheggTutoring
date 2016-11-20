class Point:
    def __init__(self, x, y):
        self.__x = x
        self.__y = y

    def setPoint(self, x, y):
        self.__x = x
        self.__y = y

    def getX(self):
        return self.__x

    def getY(self):
        return self.__y

    def printPoint(self):
        print(self.__x, self.__y)
