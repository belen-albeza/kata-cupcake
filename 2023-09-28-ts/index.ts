abstract class Cake {
  get name(): string {
    return `${this.baseName}`;
  }

  get price(): string {
    return Intl.NumberFormat("en-US", {
      style: "currency",
      currency: "USD",
    }).format(this.rawPrice);
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
