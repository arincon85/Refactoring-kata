package com.gildedrose

import com.gildedrose.updaters._

class GildedRose(val items: Seq[Item]) {
  val rules = Map(
    "Aged Brie" -> new AgedBrie,
    "Backstage passes to a TAFKAL80ETC concert" -> new BackStage,
    "Sulfuras, Hand of Ragnaros" -> new Sulfuras,
    "conjurados" -> new Conjurados
  )

  def updateQuality() {
    for (item <- items) {
      val updater = rules.getOrElse(item.name, new Default)
      updater.update(item)
    }
  }
}