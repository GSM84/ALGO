package Lesson6.Structure.Tree;

public class TreeMap<Key extends Comparable<Key>, Value> {
    Node root; // root element reference
    private int maxLevel;

    public TreeMap(int _maxLevel) {
        this.maxLevel = _maxLevel;
    }

    public TreeMap() {
        this.maxLevel = 0;
    }

    private class Node{
        Key   key;
        Value value;
        private int level;

        Node  left;
        Node  right;

        int   size;

        public Node(Key key, Value value, int _level) {
            this.key   = key;
            this.value = value;
            this.level = _level;
            this.size  = 1;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node _node){
        if(_node == null){
            return 0;
        }
        return _node.size;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private boolean isKeyNotNull(Key _key){
        if(_key == null){
            throw new IllegalArgumentException("Key can't have null value");
        }
        return true;
    }

    public Value get(Key _key){
        return get(root, _key);
    }

    private Value get(Node _node, Key _key){
        isKeyNotNull(_key);

        if(_node == null){
            return null;
        }

        int cmp = _key.compareTo(_node.key);
        if(cmp == 0){
            // key matched
            return _node.value;
        } else if (cmp < 0) {
            // key lower
            return get(_node.left, _key);
        } else {
            // key greater
            return get(_node.right, _key);
        }
    }

    public boolean contains(Key _key){
        return get(root, _key) != null;
    }

    public void put(Key _key, Value _value) throws IllegalLevelException {
        isKeyNotNull(_key);
        if(_value == null){
            //delete(_key);
            return;
        }
        root = put(root, _key, _value, 1);
    }

    private Node put(Node _node, Key _key, Value _value, int _level) throws IllegalLevelException {
        // add new node
        if(_level > maxLevel){
            throw new IllegalLevelException("Level exceeded.");
        }
        if (_node == null){
            return new Node(_key, _value, _level);
        }

        int cmp = _key.compareTo(_node.key);

        if(cmp == 0){
            _node.value = _value;
        } else if(cmp < 0){
            _node.left = put(_node.left, _key, _value, _node.getLevel() + 1);
        } else {
            _node.right = put(_node.right, _key, _value, _node.getLevel() + 1);
        }
        // recalculate node size
        _node.size = size(_node.left) + size(_node.right) + 1;

        return _node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node _node){
        if(_node == null){
            return "\n";
        }

        return toString(_node.left) + " " + _node.key.toString() + " = " + _node.value.toString() + " " + toString(_node.right);
        //return String.format("%s\n", _node.value.toString()) + toString(_node.left) + toString(_node.right);
    }

    public Key minKey(){
        return min(root).key;
    }

    private Node min(Node _node){
        if (_node.left == null) {
            return _node;
        }

        return min(_node.left);
    }

    public Key maxKey(){
        return max(root).key;
    }
    private Node max(Node _node){
        if(_node.right == null){
            return _node;
        }

        return max(_node.right);
    }

    private Node deleteMin(Node _node){
        if(_node.left == null){
            return _node.right;
        }

        _node.left = deleteMin(_node.left);
        _node.size = size(_node.left) + size(_node.right) + 1;
        return _node;
    }

    public void delete(Key _key){
        isKeyNotNull(_key);

        delete(root, _key);

    }

    private Node delete(Node _node, Key _key){
        if (_node == null){
            return null;
        }

        int cmp = _key.compareTo(_node.key);
        if (cmp == 0) {
            if (_node.left == null){
                return _node.right;
            } else if (_node.right == null) {
                return _node.left;
            }

            Node temp   = _node;
            _node       = min(_node.right);
            _node.right = deleteMin(temp.right);
            _node.left  = temp.left;

        } else if (cmp < 0){
            _node.left  = delete(_node.left, _key);
        } else {
            _node.right = delete(_node.right, _key);
        }

        _node.size = size(_node.left) + size(_node.right) + 1;

        return _node;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node _node) {
        return (_node == null) || Math.abs(height(_node.left) - height(_node.right)) < 1;
    }

    private int height(Node _node) {
        return _node == null ? 0 : 1 + Math.max(height(_node.left), height(_node.right));
    }
}
