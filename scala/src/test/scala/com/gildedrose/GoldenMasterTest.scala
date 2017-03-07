package com.gildedrose

import org.scalatest.{FlatSpec, Matchers}


class GoldenMasterTest extends FlatSpec with Matchers {
  "Update" should "modify quality and sellin" in {
    val day1 =
      """+5 Dexterity Vest, 9, 19/nAged Brie, 1, 1/nElixir of the Mongoose, 4, 6/nSulfuras, Hand of Ragnaros, 0, 80/nSulfuras, Hand of Ragnaros, -1, 80/nBackstage passes to a TAFKAL80ETC concert, 14, 21/nBackstage passes to a TAFKAL80ETC concert, 9, 50/nBackstage passes to a TAFKAL80ETC concert, 4, 50/nConjured Mana Cake, 2, 5"""

    val items = Seq(
      new Item("+5 Dexterity Vest", 10, 20), //
      new Item("Aged Brie", 2, 0), //
      new Item("Elixir of the Mongoose", 5, 7), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
      new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", 3, 6))
    val app = new GildedRose(items)
    app.updateQuality()
    items.mkString("/n") should be (day1)


  }
}