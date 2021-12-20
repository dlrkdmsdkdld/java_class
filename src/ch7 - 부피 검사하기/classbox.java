class Box{
	int width;
	int length;
	int height;
	int surface() {
		return 2*this.width*this.length+2*this.width*this.height+2*this.length*this.height;
	};
    int volume() {
		return width*length*height;
	};
	public Box(int x,int y,int z) {
		this.width=x; this.length=y; this.height=z;
	}
	
}
public class classbox{
	public static void main(String[] arg) {
		Box box1=new Box(10,13,14);//임의의 박스 크기
		Box box2=new Box(19,21,25);
		if(box1.surface()<box2.surface()) {
			System.out.println("면적 크기 순: ("+box2.surface()+", "+box2.width+", "+box2.length+", "+box2.height+"),("
					+box1.surface()+", "+box1.width+", "+box1.length+", "+box1.height+")");
		}
		else {
			System.out.println("면적 크기 순: ("+box1.surface()+", "+box1.width+", "+box1.length+", "+box1.height+"),("
					+box2.surface()+", "+box2.width+", "+box2.length+", "+box2.height+")");
	
		}
		if(box1.volume()<box2.volume()) {
			System.out.println("부피 크기 순: ("+box2.volume()+", "+box2.width+", "+box2.length+", "+box2.height+"),("
					+box1.volume()+", "+box1.width+", "+box1.length+", "+box1.height+")");
		}
		else {
			System.out.println("부피 크기 순: ("+box1.volume()+", "+box1.width+", "+box1.length+", "+box1.height+"),("
					+box2.volume()+", "+box2.width+", "+box2.length+", "+box2.height+")");
	
		}

		
		
		
		
	}
}