package com.gildedrose.updaters

import com.gildedrose.Item

class BackStage extends Updater{
  override def update(item: Item): Unit = {
    decreaseSellIn(item)
    if (qualityLessThanMax(item)) {
      increaseQuality(item)
      if (item.sellIn < 11) {
        if (qualityLessThanMax(item)) {
          increaseQuality(item)
        }
      }
      if (item.sellIn < 6) {
        if (qualityLessThanMax(item)) {
          increaseQuality(item)
        }
      }
      if (sellInDatePassed(item)) {
        item.quality = item.quality - item.quality
      }
    }
  }


}
