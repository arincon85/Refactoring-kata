package com.gildedrose

import org.scalatest._

class GildedRoseTest extends FlatSpec with Matchers {
  "GildedRose" should "decrease sellin and quality" in {
    testCaseForItem(new Item("foo", 2, 10), 1, 9)
  }
  it should "decrease quality twice if sellin equal 0" in {
    testCaseForItem(new Item("foo", 0, 10), -1, 8)
  }
  it should "quality is always > 0" in {
    testCaseForItem(new Item("foo", 1, 0), 0, 0)
  }
  it should "aged brie quality increase instead of decrease" in {
    testCaseForItem(new Item("Aged Brie", 2, 1), 1, 2)
  }
  it should "aged brie quality increase twice instead of decrease if sellIn<0" in {
    testCaseForItem(new Item("Aged Brie", -1, 1), -2, 3)
  }
  it should "max quality is 50" in {
    testCaseForItem(new Item("Aged Brie", -1, 50), -2, 50)
  }
  it should "sulfuras doesnt change" in {
    testCaseForItem(new Item("Sulfuras, Hand of Ragnaros", 2, 2), 2, 2)
  }
  it should "Backstage pass sellin <= 10 quality increase by 2" in {
    testCaseForItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2), 9, 4)
  }
  it should "Backstage pass sellin <= 5 quality increase by 3" in {
    testCaseForItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2), 4, 5)
  }
  it should "Backstage pass sellin <= -1 quality 0" in {
    testCaseForItem(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 2), -2, 0)
  }

  private def testCaseForItem(item: Item, sellIn: Int, quality: Int) = {
    val app = new GildedRose(Array[Item](item))

    app.updateQuality()

    app.items(0).sellIn should equal(sellIn)
    app.items(0).quality should equal(quality)
  }
}