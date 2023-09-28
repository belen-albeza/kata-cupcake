import { describe, it, expect } from "bun:test";
import { Cupcake, Cookie, withChocolate, withNuts, withSprinkles } from ".";

describe("Cake", () => {
  it("returns its name when it has one topping", () => {
    const c = withChocolate(new Cupcake());
    expect(c.name).toBe("🧁 with 🍫");
  });

  it("returns its name when it has multiple toppings", () => {
    const c = withSprinkles(withNuts(withChocolate(new Cookie())));
    expect(c.name).toBe("🍪 with 🍫 and 🥜 and ✨");
  });

  describe("Pricing", () => {
    it("adds up chocolate when calculating the price", () => {
      const c = withChocolate(new Cupcake());
      expect(c.price).toBe("$1.10");
    });

    it("adds up nuts when calculating the price", () => {
      const c = withNuts(new Cookie());
      expect(c.price).toBe("$2.20");
    });

    it("adds up sprinkles when calculating the price", () => {
      const c = withSprinkles(new Cupcake());
      expect(c.price).toBe("$1.10");
    });

    it("adds up all toppings when calculating the price", () => {
      const c = withNuts(withChocolate(new Cupcake()));
      expect(c.price).toBe("$1.30");
    });
  });
});

describe("Cupcake", () => {
  describe("name", () => {
    it("returns its name when it has no toppings", () => {
      const c = new Cupcake();
      expect(c.name).toBe("🧁");
    });
  });

  describe("price", () => {
    it("returns the price when it has no toppings", () => {
      const c = new Cupcake();
      expect(c.price).toBe("$1.00");
    });
  });
});

describe("Cookie", () => {
  describe("name", () => {
    it("returns its name when it has no toppings", () => {
      const c = new Cookie();
      expect(c.name).toBe("🍪");
    });
  });

  describe("price", () => {
    it("returns the price when it has no toppings", () => {
      const c = new Cookie();
      expect(c.price).toBe("$2.00");
    });
  });
});
