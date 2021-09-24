class HashTable:
    def __init__(self):
        self.capacity = 1000
        self.hashtable = [[] for _ in range(self.capacity)]
    
    def insert(self, key, value):
        hash_key = hash(key) % self.capacity
        key_exists = False
        bucket = self.hashtable[hash_key]
        
        for i,kv in enumerate(bucket):
            k,v =kv
            if key == k:
                key_exists = True
                break
        if key_exists:
            self.hashtable[hash_key][i] = (key,value)
        else:
            self.hashtable[hash_key].append((key,value))
            
    def get(self, key):
        hash_key = hash(key) % self.capacity
        key_exists = False
        
        for i,kv in enumerate(self.hashtable[hash_key]):
            k,v = kv
            if k==key:
                key_exists = True
                break
            
        if key_exists:
            return v
        else:
            return None
        
    def remove(self, key):
        hash_key = hash(key) % self.capacity
        key_exists = False
        
        for i,kv in enumerate(self.hashtable[hash_key]):
            k,v = kv
            if k==key:
                key_exists = True
                break
        
        if key_exists:
            del self.hashtable[hash_key][i]
        else:
            raise KeyError
        
if __name__ == '__main__':
    hastable = HashTable()
    hastable.insert(10,100)
    hastable.insert(20,101)
    hastable.insert(30,50000)
    print(hastable.get(10))
    print(hastable.get(20))
    print(hastable.get(30))
    print(hastable.remove(30))
    # print(hastable.remove(40)) #will raise Keyerror
    print(hastable.get(30))
   