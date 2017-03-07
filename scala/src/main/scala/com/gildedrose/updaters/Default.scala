package com.gildedrose.updaters

import com.gildedrose.Item

/**
  * Created by arincon on 7/03/17.
  */
class Default extends Updater{
  override def update(item: Item): Unit = {
    if (item.quality > 0) {
      item.quality = item.quality - 1
    }
    item.sellIn = item.sellIn - 1
    if (sellInDatePassed(item)) {
      if (item.quality > 0) {
        item.quality = item.quality - 1
      }
    }
  }

}
