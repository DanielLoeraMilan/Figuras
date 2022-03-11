# Diagrama Figuras
![Diagrama Figure](https://user-images.githubusercontent.com/98366781/157796543-7a11760b-36bf-4f5e-b6eb-d059cca76104.png)

`@startuml`

abstract class Figure{
   -{static} figuresCreated: int;
   -{final} name: String;

   #Figure(name: String)
   +{abstract}getArea(): float;
   +{abstract}getPerimeter(): float;

   +{final}getName(): String;
   +{static}getFiguresCreated(): int;

}

class Circle extends Figure{
   +getArea(): float;
   +getPerimeter(): float;
}

class Rectangle extends Figure{
   +getArea(): float;
   +getPerimeter(): float;
}

class Polygon extends Figure{
   +getArea(): float;
   +getPerimeter(): float;
}

@enduml`
