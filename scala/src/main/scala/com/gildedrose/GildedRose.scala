package com.gildedrose

class GildedRose(val items: Seq[Item]) {

  def updateQuality() {
    for (item <- items) {
      item.name match {
        case ("Aged Brie") =>
          val updater = new AgedBrie()
          updater.update(item)
        case ("Backstage passes to a TAFKAL80ETC concert") =>
          val updater = new BackStage()
          updater.update(item)
        case ("Sulfuras, Hand of Ragnaros") =>
          val updater = new Sulfuras()
          updater.update(item)
        case (_) =>
          val updater = new Default()
          updater.update(item)
      }
    }
  }
}