abstract class Cake {
  #toppings: Topping[] = [];

  get name(): string {
    return this.#toppings.length > 0
      ? `${this.baseName} with ${this.#toppings
          .map((x) => x.name)
          .join(" and ")}`
      : this.baseName;
  }

  get price(): string {
    const price = this.#toppings.reduce((acc: number, topping: Topping) => {
      return acc + topping.price;
    }, this.rawPrice);

    return Intl.NumberFormat("en-US", {
      style: "currency",
      currency: "USD",
    }).format(price);
  }

  addTopping(topping: Topping): void {
    this.#toppings.push(topping);
  }

  protected abstract get baseName(): string;
  protected abstract get rawPrice(): number;
}

export class Cupcake extends Cake {
  protected get baseName(): string {
    return "🧁";
  }

  protected get rawPrice(): number {
    return 1.0;
  }
}

export class Cookie extends Cake {
  protected get baseName(): string {
    return "🍪";
  }

  protected get rawPrice(): number {
    return 2.0;
  }
}

abstract class Topping {
  abstract get name(): string;
  abstract get price(): number;
}

class Chocolate extends Topping {
  get name(): string {
    return "🍫";
  }

  get price(): number {
    return 0.1;
  }
}

export function withChocolate(cake: Cake): Cake {
  cake.addTopping(new Chocolate());
  return cake;
}

class Nuts extends Topping {
  get name(): string {
    return "🥜";
  }

  get price(): number {
    return 0.2;
  }
}

export function withNuts(cake: Cake): Cake {
  cake.addTopping(new Nuts());
  return cake;
}

class Sprinkles extends Topping {
  get name(): string {
    return "✨";
  }

  get price(): number {
    return 0.1;
  }
}

export function withSprinkles(cake: Cake): Cake {
  cake.addTopping(new Sprinkles());
  return cake;
}
