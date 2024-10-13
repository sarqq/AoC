class Node{
	private int[] coordinates = new int[2];
	private int dangerRating;

	public Node(int x, int y){
		this.coordinates[0] = x;
		this.coordinates[1] = y;
        this.dangerRating = 1;
	}

	public void increaseRating(){
		this.dangerRating += 1;
	}
	
	public int getRating(){
		return this.dangerRating;
	}

	public int[] getCoordinates(){
		return this.coordinates;
	}

	@Override
	public String toString(){
        int x = this.getCoordinates()[0];
        int y = this.getCoordinates()[1];
		return "(" + x + "," + y + ") - danger rating: " + this.getRating();
	}

	@Override
	public boolean equals(Object obj){
		if(obj != null){
            Node other = (Node) obj;
            
            int x1 = this.getCoordinates()[0];
            int y1 = this.getCoordinates()[1];
            int x2 = other.getCoordinates()[0];
            int y2 = other.getCoordinates()[1];
		    
            //nodes are equal if their coordinates are equal
            return x1==x2 && y1==y2;
        }

        return false;
	}
}