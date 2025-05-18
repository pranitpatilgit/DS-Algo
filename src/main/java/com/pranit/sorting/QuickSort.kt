package com.pranit.sorting

class QuickSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val input = arrayOf(8, 9, 2, 5, 6, 4, 56, 4, 1, 3, 55, 6, 645, 1)
            QuickSort().sort(input)
            println("Sorted Array - ${input.toList()}")
        }
    }
    
    fun sort(input: Array<Int>){
        sort(input, 0, input.size - 1)
    }
    
    fun sort(input: Array<Int>, start: Int, end: Int) {
        if (start >= end){
            return
        }
        val pivotIndex = partition(input, start, end)
        sort(input, start, pivotIndex-1)
        sort(input, pivotIndex+1, end)
    }
    
    private fun partition(input: Array<Int>, start: Int, end: Int): Int{
        val pivot = start
        var i = start
        var j = end

        while (true) {
            while (input[i] <= input[start]) {
                i++
                if (i >= end) break
            }

            while (input[j] > input[start]) {
                j--
                if (j <= start) break
            }

            if (i >= j) {
                break
            }
            swap(input, i, j)
        }

        swap(input, pivot, j)
        return j
    }
    
    fun swap(input: Array<Int>, i: Int, j:Int) {
        var aux = input[i]
        input[i] = input[j]
        input[j] = aux
    }
}