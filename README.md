
## Resources
<Nil>

## Design and Implementation

### What and How

Data structures used : Trie & InvertedIndex. Names will be tokenized on "_" and stored in both inverted index and trie node.
It doesn't depend on "N" (total number of pairs), and runs with a much lesser complexity of O(K+MlogM) --> where K is length of the prefix & M is the number of pairs (string,value) from the token.


#### Trie:
Trie node is for faster retrieval on prefixes. To make it even faster, each node in the Trie will store the tokens along with the character map it holds.

#### InvertedIndex:
IV is used for retrieving the <String,Integer> pairs given the tokens.



```
TrieNode{
  Map<Character,TrieNode> characterMap;
  Set<String> tokens;
}

InvertedIndex:
  Map<String,List<Pair>> invertedIndex;

```

### Alternatives

* InvertedIndex alone. It would give result. But again it wouldn't be faster if there are more unique elements.
* Trie alone. It would give faster prefixes. But it would fail again while taking "_" condition into picture.

### Deployment Plan

Deploy the *.war file in the dist/ folder in any of the servers (Glassfish / Tomcat) to have it up and running.

Api to insert the intial load.
```
POST: /api
```

Api to get the strings in sorted order
```
GET: /api?prefix=<prefix>
```

Monitor:

* For monitoring the application, HIT the GET prefix API with a predefined monitoring tool like "pingdom/nagios" and setup alerts for its downtime.
