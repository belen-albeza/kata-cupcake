import { describe, it, expect } from "bun:test";
import { Cupcake, Cookie } from ".";

describe("Cupcake", () => {
  describe("name", () => {
    it("has a name when it has no toppings", () => {
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
    it("has a name when it has no toppings", () => {
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
