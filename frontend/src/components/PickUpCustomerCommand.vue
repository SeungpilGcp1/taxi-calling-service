<template>
    <v-card outlined>
        <v-card-title>
            PickUpCustomer
        </v-card-title>

        <v-card-text>
            <String label="RideId" v-model="value.rideId" :editMode="editMode"/>
            <String label="CustomerId" v-model="value.customerId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="pickUpCustomer"
            >
                PickUpCustomer
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'PickUpCustomerCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.rideId = '';
            this.value.customerId = '';
        },
        watch: {
        },
        methods: {
            pickUpCustomer() {
                this.$emit('pickUpCustomer', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

