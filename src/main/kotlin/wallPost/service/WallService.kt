package wallPost.service

import wallPost.OriginalPost

object WallService {
    //    private val id = (1..5).random()

    private var globalid = 0
    private var originalPosts = emptyArray<OriginalPost>()

    fun add(originalPost: OriginalPost): OriginalPost {
        globalid++
        val copyPost = originalPost.copy(id = globalid)
        originalPosts = originalPosts.plus(copyPost)
        return originalPosts.last()
    }

    fun getPosts(): Array<OriginalPost> {
        return originalPosts;
    }

    fun checkText(checkOriginalPost : OriginalPost) :String {
        for (originalPost: OriginalPost in getPosts()){
               if (originalPost.id == checkOriginalPost.id && originalPost.text == null){
                  return "Text is null."
           }
        }
        return "Text presents."
    }

    fun update(updateOriginalPost: OriginalPost): Boolean {
        for (originalPost: OriginalPost in getPosts()) {
            if (originalPost.id == updateOriginalPost.id) {
                originalPost.text = updateOriginalPost.text
                originalPost.ownerId = updateOriginalPost.ownerId
                return true
            }
        }
        return false
    }

}