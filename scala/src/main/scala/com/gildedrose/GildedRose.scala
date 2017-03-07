package com.gildedrose

import com.gildedrose.updaters.{AgedBrie, BackStage, Default, Sulfuras}

class GildedRose(val items: Seq[Item]) {
  val rules = Map(
    "Aged Brie" -> new AgedBrie,
    "Backstage passes to a TAFKAL80ETC concert" -> new BackStage,
    "Sulfuras, Hand of Ragnaros" -> new Sulfuras
  )

  def updateQuality() {
    for (item <- items) {
      val updater = rules.getOrElse(item.name, new Default)
      updater.update(item)
    }
  }
}