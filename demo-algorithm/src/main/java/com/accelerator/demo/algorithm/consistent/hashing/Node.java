package com.accelerator.demo.algorithm.consistent.hashing;

class Node {

    private String nodeName;

    Node(String name) {
        this.nodeName = name;
    }

    String getName() {
        return this.nodeName;
    }

    public String toString() {
        return this.nodeName;
    }

    public boolean equals(Object obj) {
        return obj instanceof Node &&
                ((Node) obj).nodeName.equals(this.nodeName);
    }

    public int hashCode() {
        return this.nodeName.hashCode();
    }
}