<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <h3>회원 가입</h3>
            <div class="row">
                <v-radio-group v-model="radioGroup" row>
                    <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`"> 
                    </v-radio>
                </v-radio-group>
                
            </div>
           <div class="mx-3"> <v-icon color="black" size="30px">person</v-icon>
                 ID
                <div class="mx-1">
                 <v-text-field placeholder="ID" v-model="userId" required >
                </v-text-field>
                 </div>
                  </div> 


            <div class="mx-3"> 
                <v-icon color="black" size="30px">lock</v-icon>
                    Password
                    <div class="mx-1">
                     <v-text-field placeholder="Password" type="password" v-model="password" required 
                     ></v-text-field>
                     </div> 
                     </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">mail</v-icon>
                 E-mail
                <div class="mx-1">
                    <v-text-field placeholder="name" v-model="email" required 
                        ></v-text-field>
                        </div> 
                        </div> 



            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                 Name
                <div class="mx-1">
                    <v-text-field placeholder="name" v-model="name" required 
                        ></v-text-field>
                        </div> 
                        </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">hourglass_empty</v-icon>
                 Age
                <div class="mx-1">
                    <v-text-field placeholder="name" v-model="age" required 
                        ></v-text-field>
                        </div> 
                        </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">wc</v-icon>
                 Sex
                <div class="mx-1">
                    <v-text-field placeholder="name" v-model="sex" required 
                        ></v-text-field>
                        </div> 
                        </div>  

            <div class="mx-3"> 
                <v-icon color="black" size="30px">phone</v-icon>
                 Phone
                <div class="mx-1">
                    <v-text-field placeholder="name" v-model="phone" required 
                        ></v-text-field>
                        </div> 
                        </div> 
                 

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </v-container>
</template>

<script>

export default {
    name: 'MemberJoinColumnTestForm',
    data () {
        return {
            radioGroup: 1,
            kindsOfMember: [
                '개인',
                '사업자'
            ],
            userId: '',
            password: '',
            email: '',
            name: '',
            age: '',
            sex: '',
            phone: ''
            
        }
    },
    methods: {
        onSubmit () {
            const { userId, password, email, name, age, sex, phone, radioGroup } = this
            const auth = radioGroup == 0 ? '개인' : '사업자'
            this.$emit('submit', { userId, name,password, email, name, age, sex, phone, auth })
        },
        
        
       
    }
}
</script>