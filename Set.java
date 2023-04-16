/**
 * The SET class represents the set of odd natural numbers.
 *
 * @author: (shira giladi/213707235)
 * @version (31.05.2022)
 */
public class Set
{
    private IntNode _head;
    /**
     * Constructor for objects of class Set
     * @param v - the head of the node
     */
    public Set(int v)
    {
        _head = new IntNode(v , null);
    }

    /**
     * Constructor for objects of class Set
     */
    public Set()
    {
        _head = null;
    }
    
    /**
     * \Constructor for objects of class Set
     * @param other - The list of the other.‏
     */
        public Set(Set other)
    {
      _head = other._head;
    }

    /**
    * Returns right if the list is empty and nothing else.
    * @returns true if the list is empty.
    * @return falsev if the list is not empty.
    * Place complications - o(1)
    * Time complications -o(n)‏
    */
    public boolean isEmpty ()
    {
        if(_head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Returns true if the value num is a member of a  the group else return false
     * @return true if the value num is a member of a  the group else return false
     * @param num- The number that is checked if it is in the group
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public boolean isMember (int num)
    {
        IntNode s = _head;
        while(s != null)
        {
            if(s.getValue() == num)
            {
                return true;
            }
            else
            {
                s = s.getNext();
            }
        }
        return false;
    }
    
    
     /**
     * Returns true if the group other is equal to the group in the object else return false
     * @param other- The group that is being tested to see if it is equal to the group that is being worked on
     * @return true if the group other is equal to the group in the object else return false
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public boolean equals (Set other)
    {
        int count1 = this.numOfElements ();
        int count2 = other.numOfElements ();
        if(count1 != count2)
        {
            return false;
        }
        else
        {
            IntNode s = this._head;
            IntNode p = other._head;
            while(s != null)
            {
                if(s.getValue() == p.getValue())
                {
                    s = s.getNext();
                    p = p.getNext();
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
    
      /**
     * Returns the number of members in the group
     * @return Returns the number of members in the group
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public int numOfElements ()
    {
        IntNode s = _head;
        int count = 0;
        while(s != null)
        {
            count++;
            s = s.getNext();
        }
        return count;
    }
    
    /**
     * Returns true if the other group is a subset of the group in the object else return false
     * @param other-The group being tested to see if it is a subgroup of the group being worked on
     * @return Returns true if the other group is a subset of the group in the object else return false
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public boolean subSet (Set other)
    {
        int count1 = this.numOfElements ();
        int count2 = other.numOfElements ();
        if(count2 > count1)
        {
            return false;
        }
        else
        {
            IntNode s = this._head;
            IntNode p = other._head;
            while(p != null)
            {
                if(s == null)
                {
                    return false;
                }

                if(s.getValue() == p.getValue())
                {
                    p = p.getNext();
                    s = s.getNext();
                }
                else
                {
                    s = s.getNext();
                }
            }
        }
        return true;
    }
    
    
    /**
     * Gets an integer and adds it to the group
     * @param x- The number added to the group
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public void addToSet (int x)
    {
        if((isMember(x) == false) && (x > 0) && (x%2 != 0))
        {
            IntNode s = _head;
            if(_head == null)
            {
                _head = new IntNode(x , null);
            }
            else if(s.getValue() > x)
            {
                _head = new IntNode(x , _head);
            }
            else
            {
                while(s.getNext() != null)
                {
                    if((s.getValue() < x) && (s.getNext().getValue() > x))
                    {
                        IntNode add = new IntNode(x , s.getNext());
                        s.setNext(add);
                    }
                    s = s.getNext();
                }
                if(isMember(x) == false)
                {
                    IntNode add = new IntNode(x , null);
                    s.setNext(add);
                }
            }
        }
    }
    
    
    /**
     * Gets an integer and removes it from the group
     * @param x-The number that is taken out of the group
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public void removeFromSet (int x)
    {
        IntNode s = _head;
        if((_head != null) && (_head.getValue() == x))
        {
            _head = _head.getNext();
        }

        while(s.getNext() != null)
        {
            if (s.getNext().getValue() == x)
            {
                s.setNext(s.getNext().getNext());
            }
            else
            {
                s = s.getNext();  
            }
        }  
    }
    
      /**
     * Returns a string with the group members
     * @return Returns a string with the group members
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public String toString()
    {
        IntNode s = _head;
        String text = "{";
        if(s == null)
        {
            return "{}";
        }
        while(s != null)
        {
            if(s.getNext() == null)
            {
                text = text + s.getValue() + "}";
            }
            else
            {
                text = text + s.getValue() + ",";
            }
            s = s.getNext();
        }
        return text;
    }
    
     /**
     * Returns the crop group of the other group with the group in the object
     * @param The group that examines what the cutting group is between it and the group that is being worked on
     * @return  return a new set of type SET which is the cut group
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public Set intersection (Set other)
    {
        IntNode s = _head;
        IntNode p = other._head;
        Set cat = new Set();
        while(p != null)
        {
            if(s == null)
            {
                return cat;
            }
            if(s.getValue() == p.getValue())
            {
                if(cat == null)
                {
                    cat = new Set(p.getValue());
                }
                else
                {
                    cat.addToSet(p.getValue());
                }
                p = p.getNext();
                s = s.getNext();
            }
            else if(s.getValue() < p.getValue())
            {
                s = s.getNext();
            }
            else
            {
                p = p.getNext();
            }
        }
        return cat;
    }
    
    /**
     * Returns the union group of the other group with the group in the object
     * @param other-The group you unite with the group you work on
     * @return Returns the union group of the other group with the group in the object
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public Set union (Set other)
    {
        IntNode s = _head;
        IntNode p = other._head;
        Set union = null;
        int count1 = this.numOfElements ();
        int count2 = other.numOfElements ();
        if(count1 >= count2)
        {
            union = new Set(this);
            if(union.subSet(other))
            {
                return union;  
            }
            else
            {
                while(p != null)
                {
                    if(union.isMember(p.getValue()))
                    {
                        p = p.getNext();
                    }
                    else
                    {
                        union.addToSet(p.getValue());
                        p = p.getNext();
                    }
                }
            }
        }
        else
        {
            union = new Set(other);
            if(union.subSet (this))
            {
                return union;  
            }
            else
            {
                while(s != null)
                {
                    if(union.isMember(s.getValue()))
                    {
                        s = s.getNext();
                    }
                    else
                    {
                        union.addToSet(s.getValue());
                        s = s.getNext();
                    }
                }
            }
        }
        return union;
    }
    
     /**
     * Returns the difference group of the group in the object less the other group
     * @param other-The group that is taken down from the group that is being worked on
     * @return  Returns the difference group of the group in the object less the other group
     * Place complications-o(1)
     * Time complications-o(n)
     */
    public Set difference (Set other)
    {
        IntNode p = other._head;
        Set less = new Set(this);
        while(p != null)
        {
            if(less.isMember(p.getValue()))
            {
                less.removeFromSet(p.getValue());
                p = p.getNext();
            }
            else
            {
                p = p.getNext();
            }
        }
        return less;
    }
}
