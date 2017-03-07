package com.gildedrose

class GildedRose(val items: Seq[Item]) {

  def updateQuality() {
    for (item <- items) {
      item.name match {
        case ("Aged Brie") => agedBrie(item)
        case ("Backstage passes to a TAFKAL80ETC concert") => backStage(item)
        case ("Sulfuras, Hand of Ragnaros") => sulfuras(item)
        case (_) => other(item)
      }
    }
  }

  private def agedBrie(item: Item) = {
    item.sellIn = item.sellIn - 1
    if (qualityLessThanMax(item)) {
      item.quality = item.quality + 1
      if (sellInDatePassed(item)) {
        item.quality = item.quality + 1
      }
    }
  }


  private def backStage(item: Item) = {
    item.sellIn = item.sellIn - 1
    if (qualityLessThanMax(item)) {
      item.quality = item.quality + 1
      if (item.sellIn < 11) {
        if (qualityLessThanMax(item)) {
          item.quality = item.quality + 1
        }
      }
      if (item.sellIn < 6) {
        if (qualityLessThanMax(item)) {
          item.quality = item.quality + 1
        }
      }
      if (sellInDatePassed(item)) {
        item.quality = item.quality - item.quality
      }
    }
  }


  private def sulfuras(item: Item) = {}

  private def other(item: Item) = {
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



  private def qualityLessThanMax(item: Item) = {
    item.quality < 50
  }

  private def sellInDatePassed(item: Item) = {
    item.sellIn < 0
  }
}