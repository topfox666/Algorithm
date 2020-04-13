import java.util.*;

/**
 * A:力扣
 * B:设计推特
 * C:优先队列+链表+hashmap+面向对象设计
 * D:设计一个推特可以发布，获取，关注，取关
 * E:  Null
 * F:优先队列中的lambda表达式要注意！
 */
class Twitter {
    private static int timestamp = 0;   //时间戳用来记录发布时间的先后
    private static class Tweet{
        private int id;     //推文号
        private int time;  //发布时间
        private Tweet next;     //内容

        // 需要传入推文内容（id）和发文时间
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;   //链表保存所有推文
        }
    }
    private static class User {
        private int id;
        public Set<Integer> followed;    //存放关注的人
        // 用户发表的推文链表头结点
        public Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            // 关注一下自己
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            // 不可以取关自己
            if (userId != this.id)
                followed.remove(userId);
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 将新建的推文插入链表头
            // 越靠前的推文 time 值越大
            twt.next = head;
            head = twt;
        }
    }

    // 我们需要一个映射将 userId 和 User 对象对应起来
    private HashMap<Integer, User> userMap = new HashMap<>();

    /** user 发表一条 tweet 动态 */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId))
            userMap.put(userId,new User(userId));
        User u=userMap.get(userId);
        u.post(tweetId);
    }

    /** 返回该 user 关注的人（包括他自己）最近的动态 id，
     最多 10 条，而且这些动态必须按从新到旧的时间线顺序排列。*/
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        Set<Integer> users=userMap.get(userId).followed;
        Queue<Tweet> q=new PriorityQueue<>(users.size(),(a,b)->(b.time-a.time));
       //将所有用户的最新一篇加入到队列
        for(int id:users) {
            Tweet twt = userMap.get(id).head;
            if (twt == null) continue;
            q.add(twt);
        }
            while(!q.isEmpty()){
                //如果已经有十条 退出
                if(res.size()==10) break;
                //时间最近的弹出
                Tweet twt=q.poll();
                res.add(twt.id);
                //下一篇插入
                if(twt.next!=null)
                q.offer(twt.next);
            }
            return res;
        }

    /** follower 关注 followee，如果 Id 不存在则新建 */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId))
            userMap.put(followerId,new User(followerId));
        if(!userMap.containsKey(followeeId))
            userMap.put(followeeId,new User(followeeId));
        User u=userMap.get(followerId);
        u.follow(followeeId);
    }

    /** follower 取关 followee，如果 Id 不存在则什么都不做 */
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId)){
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}

